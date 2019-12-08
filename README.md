# JmhBenchmark

i7-6500U @ 2.5Ghz | 8 GB DDR3

Some benchmarks:

Benchmark                                       | (NSIZE) | Mode | Cnt   |   Score    |   Error   | Units
------------------------------------------------|---------|------|-------|------------|-----------|-------
GetListElementBenchmark.getRandomFromArrayList  |  10     | avgt |  5    | 0,276      | ±0,084    | us/op
GetListElementBenchmark.getRandomFromLinkedList |  10     | avgt |  5    | 0,420      | ±0,080    | us/op

Benchmark                                       | (NSIZE) | Mode | Cnt   |   Score    |   Error   | Units
------------------------------------------------|---------|------|-------|------------|-----------|-------
GetListElementBenchmark.getRandomFromArrayList  |  100    | avgt |  5    | 2,073      | ±1,574    | us/op
GetListElementBenchmark.getRandomFromLinkedList |  100    | avgt |  5    | 5,372      | ±1,877    | us/op

Benchmark                                       | (NSIZE) | Mode | Cnt   |   Score    |   Error   | Units
------------------------------------------------|---------|------|-------|------------|-----------|-------
GetListElementBenchmark.getRandomFromArrayList  |  1000   | avgt |  5    | 16,413     | ±1,961    | us/op
GetListElementBenchmark.getRandomFromLinkedList |  1000   | avgt |  5    | 388,097    | ±77,897   | us/op

Benchmark                                       | (NSIZE) | Mode | Cnt   |   Score    |   Error   | Units
------------------------------------------------|---------|------|-------|------------|-----------|-------
GetListElementBenchmark.getRandomFromArrayList  |  10000  | avgt |  5    | 208,374    | ±109,606  | us/op
GetListElementBenchmark.getRandomFromLinkedList |  10000  | avgt |  5    | 48181,450  | ±12612,898| us/op

