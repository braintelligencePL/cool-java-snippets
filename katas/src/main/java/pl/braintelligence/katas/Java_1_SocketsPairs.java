package pl.braintelligence.katas;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java_1_SocketsPairs {

    public static int findAllPairs(int[] socketsColors) {

        List<Integer> colors = toIntegerList(socketsColors);

        var groupedColors = groupByColors(colors);

        return groupedColors.values()
                .stream()
                .map(countPairs())
                .mapToInt(Integer::intValue)
                .sum();
    }

    private static List<Integer> toIntegerList(int[] socksColors) {
        return IntStream.of(socksColors)
                .boxed()
                .collect(Collectors.toList());
    }

    private static Function<List<Integer>, Integer> countPairs() {
        return e -> e.size() / 2;
    }

    private static Map<Integer, List<Integer>> groupByColors(List<Integer> integers) {
        return integers.stream()
                .collect(
                        Collectors.groupingBy(
                                Integer::intValue
                        )
                );
    }

}

