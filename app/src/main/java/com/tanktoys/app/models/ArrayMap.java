package com.tanktoys.app.models;

import com.tanktoys.app.utils.PositionValidator;
import com.tanktoys.app.utils.customExceptions.PositionNotValidException;

public class ArrayMap {
    private String[] _positions;

    public ArrayMap(String[] positions) throws PositionNotValidException {
        SetPositions(positions);
    }

    public String[] GetPositions() {
        if (_positions != null) {
            return _positions;
        } else {
            return null;
        }
    }

    public void SetPositions(String[] positions) throws PositionNotValidException {
        if (PositionValidator.validate(positions)) {
            _positions = positions;
        } else {
            throw new PositionNotValidException();
        }
    }
}
