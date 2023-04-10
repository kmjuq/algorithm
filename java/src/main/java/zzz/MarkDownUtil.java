package zzz;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class MarkDownUtil {

    public static Table table() {
        return new Table();
    }

    public static class Table {
        private int arrLength;
        private int steps = 0;

        private final StringBuffer sb = new StringBuffer();

        private Table(){ }

        private void thead() {
            sb
                .append("\n|步骤|")
                .append(IntStream
                    .range(0,arrLength)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining("|"))
                )
                .append("|\n")
                .append("|")
                .append(IntStream
                    .range(0,arrLength + 1)
                    .mapToObj(i -> ":---:")
                    .collect(Collectors.joining("|"))
                )
                .append("|\n");
        }

        public Table tbody(String arrStr) {
            int[] ints = ArraysTool.generatorArray(arrStr);
            if (arrLength == 0) {
                this.arrLength = ints.length;
                thead();
            }
            String tbody = "|" +
                    steps +
                    "|" +
                    Arrays
                            .stream(ints)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining("|")) +
                    "|\n";
            steps++;
            sb.append(tbody);
            return this;
        }

        @Override
        public String toString(){
            return this.sb.toString();
        }

        public void print(){
            log.info(this.toString());
        }
    }

}
