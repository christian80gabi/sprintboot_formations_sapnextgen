package tn.gov.douane.formations.api.service;

import org.springframework.http.ResponseEntity;
import tn.gov.douane.formations.api.dto.UserHistoryDto;
import tn.gov.douane.formations.api.model.UserHistory;
import java.util.List;

public interface UserHistoryService {
    public List<UserHistory> getAllUserHistory();
    public UserHistory getUserHistoryById(long objId);
    public UserHistory createUserHistory(UserHistoryDto userHistoryDto);
    public UserHistory updateUserHistory(UserHistoryDto userHistoryDto, long objId);
    public ResponseEntity<UserHistory> deleteUserHistory(long objId);
}
