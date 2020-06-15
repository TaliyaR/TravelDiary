package ru.itis.semestrovaya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.semestrovaya.dto.EntryDto;
import ru.itis.semestrovaya.models.Entry;
import ru.itis.semestrovaya.models.IsPublic;
import ru.itis.semestrovaya.models.Tag;
import ru.itis.semestrovaya.models.User;
import ru.itis.semestrovaya.repositories.EntriesRepository;
import ru.itis.semestrovaya.repositories.TagRepository;
import ru.itis.semestrovaya.security.UserDetailsImpl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    EntriesRepository entriesRepository;

    @Autowired
    TagRepository tagRepository;

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public List<Entry> getList(User user) {
        List<Entry> list = entriesRepository.findAllByAuthor(user);
        list.sort(compareByDate);
        return list;
    }

    @Override
    public List<Entry> getList() {
        List<Entry> list = entriesRepository.findAllByIsPublic(IsPublic.PUBLIC);
        list.sort(compareByDate);
        return list;
    }

    @Override
    public Entry getById(Long id) {
        return entriesRepository.findById(id).orElse(null);
    }

    @Override
    public void save(EntryDto form) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) auth.getPrincipal();
        User user = userDetails.getUser();
        ArrayList<Tag> list = new ArrayList<>();
        for (String s : form.getTag()) {
            list.add(tagRepository.findTagByName(s));
        }

        Entry entry = Entry.builder()
                .title(form.getTitle())
                .date(LocalDate.parse(form.getDate()))
                .author(user)
                .text(form.getText())
                .isPublic(IsPublic.valueOf(form.getIsPublic()))
                .location(form.getLocation())
                .tags(list)
//                .filename(resultFile(form.getFile()))
                .build();

        if (form.getFile().isEmpty()) {
            entry.setFilename("e435e6e0-7e79-4f1f-9a49-f9c057f4b9b3.222ffcd7bd1dde07e2734093b24af380.jpg");
        } else {
            entry.setFilename(resultFile(form.getFile()));
        }

        entriesRepository.save(entry);
    }

    @Override
    public void deleteById(Long id) {
        entriesRepository.deleteById(id);
    }

    Comparator<Entry> compareByDate = (o1, o2) -> o2.getDate().compareTo(o1.getDate());

    private String resultFile(MultipartFile file) {
        String fileName = null;

        if (!file.isEmpty()) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            fileName = uuidFile + "." + file.getOriginalFilename();

            try {
                file.transferTo(new File(uploadPath + "/" + fileName));
            } catch (IOException e) {
                throw new IllegalArgumentException();
            }
//        }else {
//            fileName = "https://source.unsplash.com/HXjtPt_XRAQ/614x712";
        }
        return fileName;
    }

    @Override
    public List<Entry> getEntriesSortedByInterests(User user) {
        Map<Tag, Long> tagLongMap = new HashMap<>();

        List<Entry> likedEntries = user.getLikedEntries();

        for (Entry likedEntry : likedEntries) {
            for (Tag tag : likedEntry.getTags()) {
                if (!tagLongMap.containsKey(tag)) {
                    tagLongMap.put(tag, 1L);
                } else {
                    tagLongMap.replace(tag, tagLongMap.get(tag) + 1);
                }
            }
        }

        List<Entry> entries = entriesRepository.findAllByIsPublic(IsPublic.PUBLIC);

        for (Entry entry : entries) {
            Long priority = 0L;
            for (Tag tag : entry.getTags()) {
                priority += tagLongMap.containsKey(tag) ? tagLongMap.get(tag) : 0;
            }
            entry.setPriority(priority);
        }
        entries.sort((o1, o2) -> o2.getPriority().compareTo(o1.getPriority()));
        return entries;
    }

}
