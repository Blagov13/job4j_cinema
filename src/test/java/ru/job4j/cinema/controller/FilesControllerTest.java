package ru.job4j.cinema.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import ru.job4j.cinema.dto.FileDto;
import ru.job4j.cinema.service.FileService;

import java.io.IOException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FilesControllerTest {
    private FileService fileService;

    private FilesController fileController;

    private MultipartFile testFile;

    @BeforeEach
    public void initServices() {
        fileService = mock(FileService.class);
        fileController = new FilesController(fileService);
        testFile = new MockMultipartFile("test.img", new byte[]{1, 2, 3});
    }

    @Test
    public void whenRequestFileGetByIdThenResponseOk() throws IOException {
        var fileDTO = new FileDto(testFile.getOriginalFilename(), testFile.getBytes());
        when(fileService.getFileById(anyInt())).thenReturn(Optional.of(fileDTO));
        var response = fileController.getById(1);
        assertThat(response).isEqualTo(ResponseEntity.ok(fileDTO.getContent()));

    }

    @Test
    public void whenRequestFileGetByIdThenResponseNotFound() throws IOException {
        Optional<FileDto> fileDTO = Optional.empty();
        when(fileService.getFileById(anyInt())).thenReturn(fileDTO);
        var response = fileController.getById(1);
        assertThat(response).isEqualTo(ResponseEntity.notFound().build());
    }

}