package ru.itis.semestrovaya.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.semestrovaya.models.Tag;
import ru.itis.semestrovaya.repositories.TagRepository;

import java.util.List;

@Service
public class TagServiceImpl implements TagService{
    @Autowired
    TagRepository tagRepository;

    @Override
    public List<Tag> getAll(){
        return tagRepository.findAll();
    }

    @Override
    public Tag findByName(String name){
        return tagRepository.findTagByName(name);
    }
}
