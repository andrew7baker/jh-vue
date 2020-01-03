package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.VsmtApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the SmtFileUploadResource REST controller.
 *
 * @see SmtFileUploadResource
 */
@SpringBootTest(classes = VsmtApp.class)
public class SmtFileUploadResourceIT {

    private MockMvc restMockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        SmtFileUploadResource smtFileUploadResource = new SmtFileUploadResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(smtFileUploadResource)
            .build();
    }

    /**
     * Test fileupload
     */
    @Test
    public void testFileupload() throws Exception {
        restMockMvc.perform(post("/api/smt-file-upload/fileupload"))
            .andExpect(status().isOk());
    }

    /**
     * Test smtfileupload
     */
    @Test
    public void testSmtfileupload() throws Exception {
        restMockMvc.perform(get("/api/smt-file-upload/smtfileupload"))
            .andExpect(status().isOk());
    }
}
