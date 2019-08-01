package com.jason.springstudy;

import com.jason.springstudy.config.ConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureWebTestClient
public class SpringStudyApplicationTests {

    @Autowired
	private ConfigTest configTest;

	@Test
	public void testConfig() {
		System.out.println(configTest.getName());
	}

	@Test
	public void test2() throws IOException {
		File file = new File("xx");
		RandomAccessFile raf = new RandomAccessFile(file,"rw");
		//raf.seek(raf.length());
		raf.writeUTF("jason");
		raf.close();
	}

	public void test3(){

	}

}
