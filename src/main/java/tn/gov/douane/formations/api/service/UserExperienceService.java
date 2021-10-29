package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.UserExperienceDto;
import tn.gov.douane.formations.api.model.Experience;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserExperience;

import java.util.List;

public interface UserExperienceService {
    public List<UserExperience> getAllUserExperience();
    public UserExperience getUserExperienceById(long objId);
    public List<Experience> getExperiencesByUser(long userId);
    public List<User> getUsersByExperience(long expId);
    public UserExperience createUserExperience(UserExperienceDto userExperienceDto);
    public UserExperience updateUserExperience(UserExperienceDto userExperienceDto, long objId);
    public ResponseEntity<UserExperience> deleteUserExperience(long objId);
}
