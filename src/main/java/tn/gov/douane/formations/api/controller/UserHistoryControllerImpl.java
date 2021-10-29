package tn.gov.douane.formations.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.gov.douane.formations.api.dto.UserHistoryDto;
import tn.gov.douane.formations.api.model.User;
import tn.gov.douane.formations.api.model.UserHistory;
import tn.gov.douane.formations.api.service.UserHistoryServiceImpl;
import tn.gov.douane.formations.api.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/userhistory")
public class UserHistoryControllerImpl implements UserHistoryController {

    @Autowired
    private UserHistoryServiceImpl service;

    @Autowired
    private UserServiceImpl serviceUser;

    public UserHistoryControllerImpl(){ super();}

    public UserHistoryControllerImpl(UserHistoryServiceImpl service){
        super();
        this.service = service;
    }

    //get all UserHistory
    @GetMapping
    public List<UserHistory> getAllUserHistory() {
        return this.service.getAllUserHistory();
    }

    //get all UserHistory by id
    @GetMapping("/{id}")
    public UserHistory getUserHistoryById(@PathVariable(value = "id") long objId) {
        return this.service.getUserHistoryById(objId);
    }

    //create UserHistory
    @PostMapping
    public UserHistory createUserHistory(@RequestBody UserHistoryDto userHistoryDto) {

        User user = serviceUser.getUserById(userHistoryDto.getUserId());
        userHistoryDto.setUser(user);

        return this.service.createUserHistory(userHistoryDto);
    }

    //update UserHistory
    @PutMapping("/{id}")
    public UserHistory updateUserHistory(@RequestBody UserHistoryDto userHistoryDto,
                                         @PathVariable(value = "id") long objId) {

        User user = serviceUser.getUserById(userHistoryDto.getUserId());
        userHistoryDto.setUser(user);

        return this.service.updateUserHistory(userHistoryDto, objId);
    }

    //delete UserHistory
    @DeleteMapping("/{id}")
    public ResponseEntity<UserHistory> deleteUserHistory(@PathVariable(value = "id") long objId) {
        return this.service.deleteUserHistory(objId);
    }
}
