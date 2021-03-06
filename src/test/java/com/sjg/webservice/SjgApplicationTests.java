package com.sjg.webservice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.sjg.webservice.domain.posts.Posts;
import com.sjg.webservice.domain.posts.PostsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SjgApplicationTests {

	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기() {
		//given
		postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("Persuader").build());
		
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("테스트 게시글"));
		assertThat(posts.getContent(), is("테스트 본문"));
	}

	@Test
	public void BaseTimeEntity_등록() {
		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(Posts.builder().title("테스트 게시글").content("테스트 본문").author("Persuader").build());
		
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getCreatedDate(), is(now));
		assertThat(posts.getModifiedDate(), is(now));	
	}
	
	@Test
	public void 비밀번호_암호화() {
		BCryptPasswordEncoder bct = new BCryptPasswordEncoder();
		String result = bct.encode("1234");
		System.out.println("암호 ===" + result);
	}
}

