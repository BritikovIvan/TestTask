package ru.clevertec.service;

import ru.clevertec.dto.CheckDto;
import ru.clevertec.model.entity.Check;

public interface CheckService {
    Check createCheck(CheckDto checkDto);
}
