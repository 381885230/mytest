package com.demo.student;

import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	@Override
	public int getStuCount() {
		return 100;
	}

}
