package com.t3q.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t3q.jpa.model.User;


@Transactional
public interface UserDao extends JpaRepository<User, String> {

  /**
   * Return the user having the passed name or null if no user is found.
   * 
   * @param name the user name.
   */
  public User findByName(String name);
  
  public User findByEmail(String email);

  
} 