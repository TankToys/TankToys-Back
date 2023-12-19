package com.tanktoys.app.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tanktoys.app.utils.PositionValidator;
import com.tanktoys.app.utils.customExceptions.PositionNotValidException;

public class ArrayMap {
    @JsonProperty("positions")
    public String[] positions;

    public ArrayMap(String[] positions) throws PositionNotValidException {
        SetPositions(positions);
    }

    public String[] GetPositions() {
        if (this.positions != null) {
            return this.positions;
        } else {
            return null;
        }
    }

    public void SetPositions(String[] positions) throws PositionNotValidException {
        if (PositionValidator.validate(positions)) {
            this.positions = positions;
        } else {
            throw new PositionNotValidException();
        }
    }
}
