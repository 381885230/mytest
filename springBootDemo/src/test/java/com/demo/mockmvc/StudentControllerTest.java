package com.demo.mockmvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.Application;
import com.demo.student.StudentController;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class StudentControllerTest {
    private Logger logger = LoggerFactory.getLogger(StudentControllerTest.class);

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new StudentController()).build();
    }

    /**
     * 接口测试
     * @throws Exception
     */
    @Test
    public void testGetName() throws Exception {
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getName")
                .param("id", "1")
                .param("name", "yuanjin"));

        resultActions.andExpect(status().isOk());
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        logger.error(result);
    }


}
