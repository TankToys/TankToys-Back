package com.tanktoys.app.services;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tanktoys.app.models.Address;
import com.tanktoys.app.models.User;
import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

@Service
public class UserService {
    
    @Autowired
    DatabaseService db;

    public List<User> getAllUsers(){
        
        return null;
    }
    
    public User getUserByAddress(String address) throws AddressNotValidException{
        User user = new User();
        db.SelectByKey(user, address);
        if (user.user == "default") {
            user.user = null;
        }
        return user;
    }

    public User getUserByAddress(Address address) throws AddressNotValidException{
        User user = new User();
        db.SelectByKey(user, address.toString());
        if (user.user == "default") {
            user.user = null;
        }
        return user;
    }

    public boolean insertUser(User user){
        return db.Insert(user);
    }

    public boolean editUser(User user) {
        return db.Update(user, user.Getaddress().toString());
    }

    public boolean deleteUser(Address address) throws AddressNotValidException {
        User user = new User();
        return db.Delete(user, address.toString());
    }
}
