package mum.edu.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mum.edu.blog.domain.Blog;
import mum.edu.blog.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findUserById(long id);
	public User findFirstUserByUsername(String username);
}
