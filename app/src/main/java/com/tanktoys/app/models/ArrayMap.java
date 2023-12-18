package com.tanktoys.app.models;

import com.tanktoys.app.utils.PositionValidator;
import com.tanktoys.app.utils.customExceptions.PositionNotValidException;

public class ArrayMap {
    private int[][] _positions;

    public ArrayMap(int[][] positions) throws PositionNotValidException {
        SetPositions(positions);
    }

    public int[][] GetPositions() {
        if (_positions != null) {
            return _positions;
        } else {
            return null;
        }
    }

    public void SetPositions(int[][] positions) throws PositionNotValidException {
        if (PositionValidator.validate(positions)) {
            _positions = positions;
        } else {
            throw new PositionNotValidException();
        }
    }
}
