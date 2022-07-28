package com.aizoon.rendicontazione.controllers;


import com.aizoon.rendicontazione.model.dto.response.AnnouncementResponse;

import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Transactional
public class AnnouncementControllerTest extends AbstractControllerTest{


    @Test
    @WithMockUser()
    public void allAnnouncementTest() throws Exception{


        //Test della getAll() Announcements
        fromJson(get("/api/announcements", null)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*]").exists())
                .andExpect(MockMvcResultMatchers.
                        jsonPath("$.[0].announcementId").isNotEmpty()).andReturn(), AnnouncementResponse[].class);
    }



}
