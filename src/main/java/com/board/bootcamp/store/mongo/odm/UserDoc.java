package com.board.bootcamp.store.mongo.odm;

import com.board.bootcamp.model.user.User;
import com.board.bootcamp.model.user.sdo.UserCdo;
import com.board.bootcamp.model.user.vo.ERole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "User")
public class UserDoc {
    @Id
    private String id;

    private String userName;
    private String email;
    private ERole roles;
    private String password;

    public UserDoc(User user) {BeanUtils.copyProperties(user, this);}

    public UserDoc(UserCdo userCdo) {BeanUtils.copyProperties(userCdo, this);}

    public User toDomain() {
        User user = new User();
        BeanUtils.copyProperties(this, user);
        return user;
    }

    public static List<User> toDomains (List<UserDoc> userDocs) {
        return userDocs.stream().map(UserDoc::toDomain).collect(Collectors.toList());
    }
}
