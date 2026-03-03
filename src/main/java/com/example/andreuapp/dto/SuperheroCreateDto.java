package com.example.andreuapp.dto;

import java.time.Year;
import java.util.List;


public class SuperheroCreateDto {

    private String squadName;
    private String homeTown;
    private Year formed;
    private String secretBase;
    private boolean active;
    private List<MemberCreateDto> members;



    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public Year getFormed() {
        return formed;
    }

    public void setFormed(Year formed) {
        this.formed = formed;
    }

    public String getSecretBase() {
        return secretBase;
    }

    public void setSecretBase(String secretBase) {
        this.secretBase = secretBase;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<MemberCreateDto> getMembers() {
        return members;
    }

    public void setMembers(List<MemberCreateDto> members) {
        this.members = members;
    }


    public SuperheroCreateDto() {


    }


}
