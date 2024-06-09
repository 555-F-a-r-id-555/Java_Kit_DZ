package org.example;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameResult {
    private final boolean win;
    private final boolean switched;
}
