package ink.organics.openjdk11.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by 王汗超 on 2017/6/2.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDTO<T> {

    private int totalPages;

    private long totalElements;

    private Collection<T> content = new ArrayList<>();
}
