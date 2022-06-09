package com.company.service;

import com.company.exp.BadRequestException;
import com.company.enums.ProfileStatus;
import com.company.dto.AuthDTO;
import com.company.dto.ProfileDTO;
import com.company.entities.ProfileEntity;
import com.company.repository.ProfileRepository;
import com.company.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthService {
    @Autowired
    private ProfileRepository profileRepository;


    public ProfileDTO login(AuthDTO authDTO) {
        Optional<ProfileEntity> optional = profileRepository.findByLogin(authDTO.getLogin());
        if (optional.isEmpty()) {
            throw new BadRequestException("User not found");
        }
        ProfileEntity profile = optional.get();
        if (!profile.getPassword().equals(authDTO.getPassword())) {
            throw new BadRequestException("User not found");
        }

        if (!profile.getStatus().equals(ProfileStatus.ACTIVE)) {
            throw new BadRequestException("No ruxsat");
        }

        ProfileDTO dto = new ProfileDTO();
        dto.setName(profile.getName());
        dto.setSurname(profile.getSurname());
        dto.setJjwtToken(JwtUtil.encode(profile.getId()));

        return dto;
    }
}
