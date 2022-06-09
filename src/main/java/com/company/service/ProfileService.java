package com.company.service;

import com.company.exp.BadRequestException;
import com.company.dto.ProfileDTO;
import com.company.entities.ProfileEntity;
import com.company.exp.ItemNotFoundException;
import com.company.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileService {
    @Autowired
    ProfileRepository profileRepository;

    public void create(ProfileDTO dto) {
        isValid(dto);
        Optional<ProfileEntity> entity = profileRepository.findByLogin(dto.getLogin());
        if (entity.isPresent()) {
            throw new BadRequestException("Mazgi bu login oldin ro'yxatdan o'tgan");
        }

        ProfileEntity entity1 = new ProfileEntity();
        entity1.setName(dto.getName());
        entity1.setSurname(dto.getSurname());
        entity1.setLogin(dto.getLogin());
        entity1.setPassword(dto.getPassword());
        entity1.setStatus(dto.getStatus());
        entity1.setVisible(dto.getVisible());
        entity1.setCreatedDate(dto.getCreatedDate());

        profileRepository.save(entity1);
    }

    public ProfileDTO getById(Integer id) {

        Optional<ProfileEntity> optional = profileRepository.findById(id);

        if (optional.isEmpty()) {
            throw new ItemNotFoundException("Profile not fount");
        }
        ProfileEntity entity = optional.get();

        ProfileDTO dto = new ProfileDTO();
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setLogin(entity.getLogin());
        return dto;
    }

    private void isValid(ProfileDTO dto) {
        if (dto.getName() == null || dto.getName().length() < 2) {
            throw new BadRequestException("Name  xato.");
        }
        if (dto.getSurname() == null || dto.getSurname().length() < 3) {
            throw new BadRequestException("Surname required.");
        }
    }

    public void update(Integer id, ProfileDTO dto) {
        isValid(dto);

        ProfileEntity entity = get(id);
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        profileRepository.save(entity);

//        Optional<ProfileEntity> optional = profileRepository.findById(id);
//        if (optional.isEmpty()) {
//            throw new ItemNotFoundException("Profile not fount");
//        }
//        profileRepository.update_profile(dto.getName(), dto.getSurname(), id);
    }

    public void delete(Integer id) {
        Optional<ProfileEntity> profile = profileRepository.findById(id);
        if (profile.isEmpty()) {
            throw new ItemNotFoundException("Mazgi bu idli foydalanuvchi yo'q");
        }
        profileRepository.deleteById(id);
    }

    public ProfileEntity get(Integer id) {
        return profileRepository.findById(id).orElseThrow(() -> {
            throw new ItemNotFoundException("Profile Not found");
        });
    }
}
