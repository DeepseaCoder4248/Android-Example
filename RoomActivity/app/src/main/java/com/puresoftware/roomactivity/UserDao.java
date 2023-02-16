package com.puresoftware.roomactivity;

// Delete,add,op? 머시기의 기능을 가진 인터페이스

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Insert
    void insert(User user);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Query("DELETE FROM user where first_name LIKE :firstName")
    void deleteByName(String firstName);

    // update 테이블명 set 컬럼1=값1, 컬럼2=값2
    @Query("UPDATE user set first_name=:first where uid=:uid")
    void updateFirstName(int uid, String first);
}
