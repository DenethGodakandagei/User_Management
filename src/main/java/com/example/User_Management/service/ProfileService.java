package com.example.User_Management.service;

import com.example.User_Management.io.ProfileRequest;
import com.example.User_Management.io.ProfileResponse;

public interface ProfileService {

 ProfileResponse createProfile(ProfileRequest request);
}
