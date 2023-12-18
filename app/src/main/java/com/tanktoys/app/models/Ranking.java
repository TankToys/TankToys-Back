package com.tanktoys.app.models;

import java.util.Set;

import com.tanktoys.app.utils.customExceptions.AddressNotValidException;

import jakarta.validation.constraints.NotNull;

public class Ranking {
    @NotNull(message = "Address cannot be null")
    private Address _address;

    private int _rankModeA;

    private int _rankModeB;

    private int _rankModeC;

    public Ranking(String address, int rankModeA, int rankModeB, int rankModeC) throws AddressNotValidException {
        SetRanking(address, rankModeA, rankModeB, rankModeC);
    }

    public void SetRanking(String address, int rankModeA, int rankModeB, int rankModeC) throws AddressNotValidException {
        _address = new Address(address);
        _rankModeA = rankModeA;
        _rankModeB = rankModeB;
        _rankModeC = rankModeC;
    }
}
