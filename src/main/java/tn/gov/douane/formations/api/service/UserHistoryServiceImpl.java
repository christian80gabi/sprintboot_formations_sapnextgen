package tn.gov.douane.formations.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.gov.douane.formations.api.dto.UserHistoryDto;
import tn.gov.douane.formations.api.exception.ResourceNotFoundException;
import tn.gov.douane.formations.api.function.AdressIP;
import tn.gov.douane.formations.api.function.GDate;
import tn.gov.douane.formations.api.function.GStatutObj;
import tn.gov.douane.formations.api.model.UserHistory;
import tn.gov.douane.formations.api.repository.UserHistoryRepository;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UserHistoryServiceImpl implements UserHistoryService {

    @Autowired
    private UserHistoryRepository repo;

    public UserHistoryServiceImpl() {
        super();
    }

    public UserHistoryServiceImpl(UserHistoryRepository repo) {
        super();
        this.repo = repo;
    }

    @Override
    public List<UserHistory> getAllUserHistory(){
        return this.repo.findAll();
    }

    @Override
    public UserHistory getUserHistoryById(long objId) {

        return this.repo.findById(objId).
                orElseThrow(
                        ()->new ResourceNotFoundException("User history not found with id :"+objId)
                );
    }

    @Override
    public UserHistory createUserHistory(UserHistoryDto userHistoryDto) {

        Timestamp time = GDate.precisionDateTime;
        UserHistory userHistory = new UserHistory();

        userHistory.setUserHistoryIpAdress(AdressIP.IP);
        userHistory.setUserHistoryFlag(userHistoryDto.getUserHistoryFlag());
        userHistory.setUserId(userHistoryDto.getUser());
        userHistory.setUserHistoryCreateAt(time);
        userHistory.setUserHistoryUpdateAt(time);
        userHistory.setUserHistoryDeleteAt(time);
        userHistory.setUserHistoryStatut(GStatutObj.ADD);

        return this.repo.save(userHistory);
    }

    @Override
    public UserHistory updateUserHistory(UserHistoryDto userHistoryDto, long objId) {

        Timestamp time = GDate.precisionDateTime;
        UserHistory existingUserHistory = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User history not found with id :"+objId));

        existingUserHistory.setUserHistoryFlag(userHistoryDto.getUserHistoryFlag());
        existingUserHistory.setUserId(userHistoryDto.getUser());
        existingUserHistory.setUserHistoryUpdateAt(time);
        existingUserHistory.setUserHistoryStatut(GStatutObj.UPDATE);

        return this.repo.save(existingUserHistory);
    }

    @Override
    public ResponseEntity<UserHistory> deleteUserHistory(long objId) {

        //Timestamp time = GDate.precisionDateTime;
        UserHistory existingUserHistory = this.repo.findById(objId).orElseThrow(
                ()->new ResourceNotFoundException("User history not found with id :"+objId));
        /*existingPosteStatut.setDeleteAt(time);
        existingPosteStatut.setStatut(GStatutObj.DELETE);*/
        this.repo.delete(existingUserHistory);
        return ResponseEntity.ok().build();
    }
}
