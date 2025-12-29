package storage_app.dto;

import lombok.Data;

import java.util.List;

@Data
public class PageResponseDTO<T> {
    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private long totalPages;
}
