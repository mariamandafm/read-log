package com.amanda.readlog.mappers;

import com.amanda.readlog.dto.BookDto;
import com.amanda.readlog.dto.ClubDto;
import com.amanda.readlog.dto.ReadingDto;
import com.amanda.readlog.model.Book;
import com.amanda.readlog.model.Club;
import com.amanda.readlog.model.Reading;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReadingMapperImpl implements Mapper<Reading, ReadingDto> {

    private final ModelMapper modelMapper;

    public ReadingMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ReadingDto mapTo(Reading reading) {
        return modelMapper.map(reading, ReadingDto.class);
    }

    @Override
    public Reading mapFrom(ReadingDto readingDto) {
//        modelMapper.createTypeMap(ClubDto.class, Club.class);
//        modelMapper.createTypeMap(BookDto.class, Book.class);

        return modelMapper.map(readingDto, Reading.class);
    }
}
