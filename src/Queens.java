/**
 * а шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
 *
 *
 * смысл такой: нужно 2 одномерных массива.
 * first - [1,2,3,4,5,6,7,8] is i (горизонталь)
 * second - j from 1 to 8 (вертикальный координаты) с отбором (не долно быть повторений и
 * проверка восходящей диагонали i+j и нисходящей i-j)
 * ??? Как сделать чертовый возврат, если местоположение королевы не походит???
 *
 */
/*
public class Queens {
    final int board_size = 8;
*/