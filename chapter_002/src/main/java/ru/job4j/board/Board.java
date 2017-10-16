package ru.job4j.board;

/**
* Класс Board формирует шахматную доску, создает набор фигур.
* @author Konstantin Kolganov (kkolganov.92@gmail.com)
* @since 03.10.2017
* @version 2.0
*/

public class Board {
/**
* Класс Board.
*/
	private Cell[][] board = new Cell[8][8]; /**Массив ячеек, формирующий шахматную доску.*/
	private Coordinate[][] coordCell = new Coordinate[8][8]; /**Массив координат.*/
	private Figure[][] figure = new Figure[4][8]; /**Массив шахматных фигур.*/
	private String[][] designCols = {{"0", "1", "2", "3", "4", "5", "6", "7"},
									{"a", "b", "c", "d", "e", "f", "g", "h"}}; /**Буквы по столбцам.*/
	private String[][] designLine = {{"0", "1", "2", "3", "4", "5", "6", "7"},
									{"8", "7", "6", "5", "4", "3", "2", "1"}}; /**Цифры по строкам.*/
/**
* Метод move.
* @param source Ячейка отправления.
* @param dist Ячейка назначения.
* @return true, если фигура есть, она может передвинуться в указанную ячейку.
* И на пути не стоит других фигур.
* @throws ImpossibleMoveException Если логика фигуры не позволяет передвинуться в указанную ячейку.
* @throws OccupiedWayException Если на пути стоит другая фигура.
* @throws FigureNotFoundException Если в указанной ячейке нет фигуры.
*/
	boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
		boolean check = true;
		Cell[] cell = null;
		Figure fig = this.findFig(source);
		if (fig != null) {
			cell = fig.way(dist);
			for (Cell var : cell) {
				if (this.findFig(var) != null) {
					throw new OccupiedWayException("On the way there is a figure!");
				}
			}
		} else {
			throw new FigureNotFoundException("Figure not found!");
		}
		return check;
	}
/**
* Метод .
* Принимает адрес ячейки в формате "Буква-цифра", возвращает адрес ячейки массива.
* @param cell Адрес ячейки "Буква-цифра".
* @return Ячейка.
* @throws CoordinatesFormatException Если неправильная форма записи координаты.
*/
	public Cell translate(String cell) {
		Cell retCell = null;
		int column = 0;
		int string = 0;
		String delimetr = "-";
		String[] substr;
		substr = cell.split(delimetr);
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 8; i++) {
				if (substr[j].equals(this.designCols[1][i])) {
					column = Integer.parseInt(this.designCols[0][i]);
				}
			}
			for (int i = 0; i < 8; i++) {
				if (substr[j].equals(this.designLine[1][i])) {
					string = Integer.parseInt(this.designLine[0][i]);
				}
			}
		}
		try {
			if (string != 0 && column != 0) {
				retCell = this.board[string][column];
			} else {
				throw new CoordinatesFormatException("Incorrect format. Try again.");
			}
		} catch (CoordinatesFormatException cfe) {
			System.out.println("Incorrect format. Try again.");
		}
		return retCell;
	}
/**
* Метод createBoard.
* Создание шахматной доски.
*/
	public void createBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						this.board[i][j] = new Cell("White");
					} else {
						this.board[i][j] = new Cell("Black");
					}
				} else {
					if (j % 2 == 0) {
						this.board[i][j] = new Cell("Black");
					} else {
						this.board[i][j] = new Cell("White");
					}
				}
			}
		}
	}
/**
* Метод createCoordinate.
* Создание массива координат ячеек.
*/
	public void createCoordinate() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				this.coordCell[i][j] = new Coordinate(i, j, this.board[i][j]);
			}
		}
	}
/**
* Метод findFig. Поиск фигуры по ячейке.
* @param cell Ячейка.
* @return Фигура.
*/
	public Figure findFig(Cell cell) {
		Figure fig = null;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				if (cell.equals(this.figure[i][j].getPosition())) {
					fig = this.figure[i][j];
				}
			}
		}
		return fig;
	}
/**
* Метод findCoord. Получение координаты ячейки.
* @param cell Ячейка.
* @return Координата.
*/
	public Coordinate findCoord(Cell cell) {
		Coordinate coordinate = null;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (cell.equals(this.coordCell[i][j].getCell())) {
					coordinate = this.coordCell[i][j];
				}
			}
		}
		return coordinate;
	}
/**
* Метод createFigure.
* Создание массива фигур и расстановка их в клетки массива board.
* По правилам шахмат.
*/
	public void createFigure() {
		for (int i = 0; i < 4; i++) {
			switch (i) {
				case 0:
					for (int j = 0; j < 8; j++) {
						if (j == 0 || j == 7) {
							this.createShallop(i, j, "Black");
						}
						if (j == 1 || j == 6) {
							this.createHorse(i, j, "Black");
						}
						if (j == 2 || j == 5) {
							this.createElephant(i, j, "Black");
						}
						if (j == 3) {
							this.createQueen(i, j, "Black");
						}
						if (j == 4) {
							this.createKing(i, j, "Black");
						}
					}
					break;
				case 1:
					for (int j = 0; j < 8; j++) {
						this.createPawn(i, j, "Black");
					}
					break;
				case 2:
					for (int j = 0; j < 8; j++) {
						this.createPawn(i, j, "White");
					}
					break;
				case 3:
					for (int j = 0; j < 8; j++) {
						if (j == 0 || j == 7) {
							this.createShallop(i, j, "White");
						}
						if (j == 1 || j == 6) {
							this.createHorse(i, j, "White");
						}
						if (j == 2 || j == 5) {
							this.createElephant(i, j, "White");
						}
						if (j == 3) {
							this.createQueen(i, j, "White");
						}
						if (j == 4) {
							this.createKing(i, j, "White");
						}
					}
					break;
				default:
					break;
			}
		}
	}
/**
* Метод createPawn.
* Создает Пешку и кладет ее в массив фигур и соответствующую ячейку доски.
* @param i Инициализатор первого измерения массива.
* @param j Инициализатор второго измерения массива.
* @param color Цвет фигуры.
*/
	public void createPawn(int i, int j, String color) {
		if ("White".equals(color)) {
			this.figure[i][j] = new Figure("Pawn", "White", this.board[6][j]) {
/**
* Метод way.
* Определяет возможность передвижения фигуры к заданной ячейке.
* @param dist Текущая ячейка.
* @return Массив ячеек, через которые необходимо пройти фигуре.
* @throws ImposibleMoveException Исключение, если невозможно пройти к ячейке.
*/
				public Cell[] way(Cell dist) throws ImpossibleMoveException {
					Cell[] cell = null;
					int actX = findCoord(this.getPosition()).getX();
					int actY = findCoord(this.getPosition()).getY();
					int distX = findCoord(dist).getX();
					int distY = findCoord(dist).getY();
					int diffX = distX - actX;
					int diffY = distY - actY;
					if (diffX == 0 && diffY == -1) {
						cell = new Cell[1];
						cell[0] = board[distY][distX];
					} else {
						throw new ImpossibleMoveException("Moving is impossible. Select another cell.");
					}
					return cell;
				}
			};
		}
		if ("Black".equals(color)) {
			this.figure[i][j] = new Figure("Pawn", "Black", this.board[i][j]) {
/**
* Метод way.
* Определяет возможность передвижения фигуры к заданной ячейке.
* @param dist Текущая ячейка.
* @return Массив ячеек, через которые необходимо пройти фигуре.
* @throws ImposibleMoveException Исключение, если невозможно пройти к ячейке.
*/
				public Cell[] way(Cell dist) throws ImpossibleMoveException {
					Cell[] cell = null;
					int actX = findCoord(this.getPosition()).getX();
					int actY = findCoord(this.getPosition()).getY();
					int distX = findCoord(dist).getX();
					int distY = findCoord(dist).getY();
					int diffX = distX - actX;
					int diffY = distY - actY;
					if (diffX == 0 && diffY == 1) {
						cell = new Cell[1];
						cell[0] = board[distY][distX];
					} else {
						throw new ImpossibleMoveException("Moving is impossible. Select another cell.");
					}
					return cell;
				}
			};
		}
	}
/**
* Метод createShallop.
* Создает Ладью и кладет ее в массив фигур и соответствующую ячейку доски.
* @param i Инициализатор первого измерения массива.
* @param j Инициализатор второго измерения массива.
* @param color Цвет фигуры.
*/
	public void createShallop(int i, int j, String color) {
		if ("White".equals(color)) {
			this.figure[i][j] = new Figure("Shallop", "White", this.board[7][j]) {
/**
* Метод way.
* Определяет возможность передвижения фигуры к заданной ячейке.
* @param dist Текущая ячейка.
* @return Массив ячеек, через которые необходимо пройти фигуре.
* @throws ImposibleMoveException Исключение, если невозможно пройти к ячейке.
*/
				public Cell[] way(Cell dist) throws ImpossibleMoveException {
					Cell[] cell = null;
					int actX = findCoord(this.getPosition()).getX();
					int actY = findCoord(this.getPosition()).getY();
					int distX = findCoord(dist).getX();
					int distY = findCoord(dist).getY();
					int diffX = distX - actX;
					int diffY = distY - actY;
					int index = 0; // счетчик массива
					if (diffY <= 0 && (diffX == 0 || diffY == 0)) {
						switch ((diffX == 0 ? 1 : 2)) {
							case 1:
								cell = new Cell[(-diffY)];
								for (int i = actY - 1; i >= distY; i--) {
									cell[index] = board[i - index][distX];
									index++;
								}
								break;
							case 2:
								if (diffX > 0) {
									cell = new Cell[diffX];
									for (int i = actX + 1; i <= distX; i++) {
										cell[index] = board[distY][i + index];
										index++;
									}
								} else {
									cell = new Cell[(actX - distX)];
									for (int i = actX - 1; i >= distX; i--) {
										cell[index] = board[distY][i - index];
										index++;
									}
								}
								break;
							default:
								break;
						}
					} else {
						throw new ImpossibleMoveException("Moving is impossible. Select another cell.");
					}
					return cell;
				}
			};
		}
		if ("Black".equals(color)) {
			this.figure[i][j] = new Figure("Shallop", "Black", this.board[i][j]) {
/**
* Метод way.
* Определяет возможность передвижения фигуры к заданной ячейке.
* @param dist Текущая ячейка.
* @return Массив ячеек, через которые необходимо пройти фигуре.
* @throws ImposibleMoveException Исключение, если невозможно пройти к ячейке.
*/
				public Cell[] way(Cell dist) throws ImpossibleMoveException {
					Cell[] cell = null;
					// Координата X текущей ячейки
					int actX = findCoord(this.getPosition()).getX();
					// Координата Y текущей ячейки
					int actY = findCoord(this.getPosition()).getY();
					// Координата X ячейки назначения
					int distX = findCoord(dist).getX();
					// Координата Y ячейки назначения
					int distY = findCoord(dist).getY();
					// Разница координат X
					int diffX = distX - actX;
					// Разница координат Y
					int diffY = distY - actY;
					int index = 0; // счетчик массива
						// Если конечная ячейка впереди и на одной линии по
						// горизонтали или вертикали
						if (diffY >= 0 && (diffX == 0 || diffY == 0)) {
							switch ((diffX == 0 ? 1 : 2)) {
								case 1:
									cell = new Cell[diffY];
									for (int i = actY + 1; i <= distY; i++) {
										cell[index] = board[i + index][distX];
										index++;
									}
									break;
								case 2:
									if (diffX > 0) {
										cell = new Cell[diffX];
										for (int i = actX + 1; i <= distX; i++) {
											cell[index] = board[distY][i + index];
											index++;
										}
									} else {
										cell = new Cell[(actX - distX)];
										for (int i = actX - 1; i >= distX; i--) {
											cell[index] = board[distY][i - index];
											index++;
										}
									}
									break;
								default:
									break;
							}
						} else {
							throw new ImpossibleMoveException("Moving is impossible. Select another cell.");
						}
					return cell;
				}
			};
		}
	}
/**
* Метод createHorse.
* Создает Лошадь и кладет ее в массив фигур и соответствующую ячейку доски.
* @param i Инициализатор первого измерения массива.
* @param j Инициализатор второго измерения массива.
* @param color Цвет фигуры.
*/
	public void createHorse(int i, int j, String color) {
		if ("White".equals(color)) {
			this.figure[i][j] = new Figure("Horse", "White", this.board[7][j]) {
/**
* Метод way.
* Определяет возможность передвижения фигуры к заданной ячейке.
* @param dist Текущая ячейка.
* @return Массив ячеек, через которые необходимо пройти фигуре.
* @throws ImposibleMoveException Исключение, если невозможно пройти к ячейке.
*/
				public Cell[] way(Cell dist) throws ImpossibleMoveException {
					Cell[] cell = null;
					int actX = findCoord(this.getPosition()).getX();
					int actY = findCoord(this.getPosition()).getY();
					int distX = findCoord(dist).getX();
					int distY = findCoord(dist).getY();
					int diffX = distX - actX;
					int diffY = distY - actY;
					// Два вперед и один влево
					if (diffY == -2 && diffX == -1) {
						cell = new Cell[1];
						cell[0] = board[distY][distX];
					// Два вперед и один вправо
					} else if (diffY == -2 && diffX == 1) {
						cell = new Cell[1];
						cell[0] = board[distY][distX];
					// Один вперед и два влево
					} else if (diffY == -1 && diffX == -2) {
						cell = new Cell[1];
						cell[0] = board[distY][distX];
					// Один вперед и два вправо
					} else if (diffY == -1 && diffX == 2) {
						cell = new Cell[1];
						cell[0] = board[distY][distX];
					} else {
						throw new ImpossibleMoveException("Moving is impossible. Select another cell.");
					}
					return cell;
				}
			};
		}
		if ("Black".equals(color)) {
			this.figure[i][j] = new Figure("Horse", "Black", this.board[i][j]) {
/**
* Метод way.
* Определяет возможность передвижения фигуры к заданной ячейке.
* @param dist Текущая ячейка.
* @return Массив ячеек, через которые необходимо пройти фигуре.
* @throws ImposibleMoveException Исключение, если невозможно пройти к ячейке.
*/
				public Cell[] way(Cell dist) throws ImpossibleMoveException {
					Cell[] cell = null;
					// Координата X текущей ячейки
					int actX = findCoord(this.getPosition()).getX();
					// Координата Y текущей ячейки
					int actY = findCoord(this.getPosition()).getY();
					// Координата X ячейки назначения
					int distX = findCoord(dist).getX();
					// Координата Y ячейки назначения
					int distY = findCoord(dist).getY();
					// Разница координат X
					int diffX = distX - actX;
					// Разница координат Y
					int diffY = distY - actY;
					// Два вперед и один влево
					if (diffY == 2 && diffX == 1) {
						cell = new Cell[1];
						cell[0] = board[distY][distX];
					// Два вперед и один вправо
					} else if (diffY == 2 && diffX == -1) {
						cell = new Cell[1];
						cell[0] = board[distY][distX];
					// Один вперед и два влево
					} else if (diffY == 1 && diffX == 2) {
						cell = new Cell[1];
						cell[0] = board[distY][distX];
					// Один вперед и два вправо
					} else if (diffY == 1 && diffX == -2) {
						cell = new Cell[1];
						cell[0] = board[distY][distX];
					} else {
						throw new ImpossibleMoveException("Moving is impossible. Select another cell.");
					}
					return cell;
				}
			};
		}
	}
/**
* Метод createElephant.
* Создает Слона и кладет его в массив фигур и соответствующую ячейку доски.
* @param i Инициализатор первого измерения массива.
* @param j Инициализатор второго измерения массива.
* @param color Цвет фигуры.
*/
	public void createElephant(int i, int j, String color) {
		if ("White".equals(color)) {
			this.figure[i][j] = new Figure("Elephant", "White", this.board[7][j]) {
				public Cell[] way(Cell dist) throws ImpossibleMoveException {
/**
* Метод way.
* Определяет возможность передвижения фигуры к заданной ячейке.
* @param dist Текущая ячейка.
* @return Массив ячеек, через которые необходимо пройти фигуре.
* @throws ImposibleMoveException Исключение, если невозможно пройти к ячейке.
*/
					Cell[] cell = null;
					int actX = findCoord(this.getPosition()).getX();
					int actY = findCoord(this.getPosition()).getY();
					int distX = findCoord(dist).getX();
					int distY = findCoord(dist).getY();
					int diffX = distX - actX;
					int diffY = distY - actY;
					int index = 0;
					if (diffY < 0 && diffY == (diffX < 0 ? diffX : -diffX)) {
						switch ((diffX > 0 ? 1 : 2)) {
							case 1:
								cell = new Cell[diffX];
								for (int i = actX + 1; i <= distX; i++) {
									cell[index] = board[actY - 1 - index][i];
									index++;
								}
								break;
							case 2:
								cell = new Cell[((actX - distX))];
								for (int i = actX - 1; i >= distX; i--) {
									cell[index] = board[actY - 1 - index][i];
									index++;
								}
								break;
							default:
								break;
						}
					} else {
						throw new ImpossibleMoveException("Moving is impossible. Select another cell.");
					}
					return cell;
				}
			};
		}
		if ("Black".equals(color)) {
			this.figure[i][j] = new Figure("Elephant", "Black", this.board[i][j]) {
/**
* Метод way.
* Определяет возможность передвижения фигуры к заданной ячейке.
* @param dist Текущая ячейка.
* @return Массив ячеек, через которые необходимо пройти фигуре.
* @throws ImposibleMoveException Исключение, если невозможно пройти к ячейке.
*/
				public Cell[] way(Cell dist) throws ImpossibleMoveException {
					Cell[] cell = null;
					int actX = findCoord(this.getPosition()).getX();
					int actY = findCoord(this.getPosition()).getY();
					int distX = findCoord(dist).getX();
					int distY = findCoord(dist).getY();
					int diffX = distX - actX;
					int diffY = distY - actY;
					int index = 0;
					if ("Black".equals(color)) {
						if (diffY > 0 && diffY == (diffX > 0 ? diffX : -diffX)) {
							switch ((diffX > 0 ? 1 : 2)) {
								case 1:
									cell = new Cell[diffX];
									for (int i = actX + 1; i <= distX; i++) {
										cell[index] = board[actY + 1 + index][i];
										index++;
									}
									break;
								case 2:
									cell = new Cell[((actX - distX))];
									for (int i = actX - 1; i >= distX; i--) {
										cell[index] = board[actY + 1 + index][i];
										index++;
									}
									break;
								default:
									break;
							}
						} else {
							throw new ImpossibleMoveException("Moving is impossible. Select another cell.");
						}
					}
					return cell;
				}
			};
		}
	}
/**
* Метод createQueen.
* Создает Ферзя и кладет его в массив фигур и соответствующую ячейку доски.
* @param i Инициализатор первого измерения массива.
* @param j Инициализатор второго измерения массива.
* @param color Цвет фигуры.
*/
	public void createQueen(int i, int j, String color) {
		if ("White".equals(color)) {
			this.figure[i][j] = new Figure("Queen", "White", this.board[7][j]) {
				public Cell[] way(Cell dist) throws ImpossibleMoveException {
/**
* Метод way Определяет возможность передвижения фигуры к заданной ячейке.
* @param dist Текущая ячейка.
* @return Массив ячеек, через которые необходимо пройти фигуре.
* @throws ImposibleMoveException Исключение, если невозможно пройти к ячейке.
*/
					Cell[] cell = null;
					int actX = findCoord(this.getPosition()).getX();
					int actY = findCoord(this.getPosition()).getY();
					int distX = findCoord(dist).getX();
					int distY = findCoord(dist).getY();
					int diffX = distX - actX;
					int diffY = distY - actY;
					int index = 0;
					if (diffY <= 0 && (diffY == (diffX < 0 ? diffX : -diffX) || diffX == 0 || diffY == 0)) {
						if (diffX == 0 || diffY == 0) {
							switch ((diffX == 0 ? 1 : 2)) {
								case 1:
									cell = new Cell[(actY - distY)];
									for (int i = actY - 1; i >= distY; i--) {
										cell[index] = board[i - index][distX];
										index++;
									}
									break;
								case 2:
									if (diffX > 0) {
										cell = new Cell[diffX];
										for (int i = actX + 1; i <= distX; i++) {
											cell[index] = board[distY][i + index];
											index++;
										}
									} else {
										cell = new Cell[((actX - distX))];
										for (int i = actX - 1; i >= distX; i--) {
											cell[index] = board[distY][i - index];
											index++;
										}
									}
									break;
								default:
									break;
							}
						} else {
							switch ((diffX > 0 ? 1 : 2)) {
								case 1:
									cell = new Cell[diffX];
									for (int i = actX + 1; i <= distX; i++) {
										cell[index] = board[actY - 1 - index][i];
										index++;
									}
									break;
								case 2:
									cell = new Cell[((actX - distX))];
									for (int i = actX - 1; i >= distX; i--) {
										cell[index] = board[actY - 1 - index][i];
										index++;
									}
									break;
								default:
									break;
							}
						}
					} else {
						throw new ImpossibleMoveException("Moving is impossible. Select another cell.");
					}
					return cell;
				}
			};
		}
		if ("Black".equals(color)) {
			this.figure[i][j] = new Figure("Queen", "Black", this.board[i][j]) {
/**
* Метод way Определяет возможность передвижения фигуры к заданной ячейке.
* @param dist Текущая ячейка.
* @return Массив ячеек, через которые необходимо пройти фигуре.
* @throws ImposibleMoveException Исключение, если невозможно пройти к ячейке.
*/
				public Cell[] way(Cell dist) throws ImpossibleMoveException {
					Cell[] cell = null;
					int actX = findCoord(this.getPosition()).getX();
					int actY = findCoord(this.getPosition()).getY();
					int distX = findCoord(dist).getX();
					int distY = findCoord(dist).getY();
					int diffX = distX - actX;
					int diffY = distY - actY;
					int index = 0;
					if (diffY >= 0 && (diffY == (diffX > 0 ? diffX : -diffX) || diffX == 0 || diffY == 0)) {
						if (diffX == 0 || diffY == 0) {
							switch ((diffX == 0 ? 1 : 2)) {
								case 1:
									cell = new Cell[diffY];
									for (int i = actY + 1; i <= distY; i++) {
										cell[index] = board[i + index][distX];
										index++;
									}
									break;
								case 2:
									if (diffX > 0) {
										cell = new Cell[diffX];
										for (int i = actX + 1; i <= distX; i++) {
											cell[index] = board[distY][i + index];
											index++;
										}
									} else {
										cell = new Cell[((actX - distX))];
										for (int i = actX - 1; i >= distX; i--) {
											cell[index] = board[distY][i - index];
											index++;
										}
									}
									break;
								default:
									break;
							}
						} else {
							switch ((diffX > 0 ? 1 : 2)) {
								case 1:
									cell = new Cell[diffX];
									for (int i = actX + 1; i <= distX; i++) {
										cell[index] = board[actY + 1 + index][i];
										index++;
									}
									break;
								case 2:
									cell = new Cell[(actX - distX)];
									for (int i = actX - 1; i >= distX; i--) {
										cell[index] = board[actY + 1 + index][i];
										index++;
									}
									break;
								default:
									break;
							}
						}
					} else {
						throw new ImpossibleMoveException("Moving is impossible. Select another cell.");
					}
					return cell;
				}
			};
		}
	}
/**
* Метод createKing.
* Создает Короля и кладет его в массив фигур и соответствующую ячейку доски.
* @param i Инициализатор первого измерения массива.
* @param j Инициализатор второго измерения массива.
* @param color Цвет фигуры.
*/
	public void createKing(int i, int j, String color) {
		if ("White".equals(color)) {
			this.figure[i][j] = new Figure("King", "White", this.board[7][j]) {
				public Cell[] way(Cell dist) throws ImpossibleMoveException {
/**
* Метод way.
* Определяет возможность передвижения фигуры к заданной ячейке.
* @param dist Текущая ячейка.
* @return Массив ячеек, через которые необходимо пройти фигуре.
* @throws ImposibleMoveException Исключение, если невозможно пройти к ячейке.
*/
					Cell[] cell = null;
					int actX = findCoord(this.getPosition()).getX();
					int actY = findCoord(this.getPosition()).getY();
					int distX = findCoord(dist).getX();
					int distY = findCoord(dist).getY();
					int diffX = distX - actX;
					int diffY = distY - actY;
					if (((diffY == -1 || diffY == 0) && (diffX == 1 || diffX == -1)) || (diffY == -1 && diffX == 0)) {
						if ((diffY == -1 || diffY == 0) && (diffX == 1 || diffX == -1)) {
							switch (((diffY == -1 && (diffX == 1 || diffX == -1)) ? 1 : 2)) {
								case 1:
									if (diffY == -1 && diffX == 1) {
										cell = new Cell[1];
										cell[0] = board[distY][distX];
									} else {
										cell = new Cell[1];
										cell[0] = board[distY][distX];
									}
									break;
								case 2:
									if (diffY == 0 && diffX == 1) {
										cell = new Cell[1];
										cell[0] = board[distY][distX];
									} else {
										cell = new Cell[1];
										cell[0] = board[distY][distX];
									}
									break;
							default:
								break;
							}
						} else {
							cell = new Cell[1];
							cell[0] = board[distY][distX];
						}
					} else {
						throw new ImpossibleMoveException("Moving is impossible. Select another cell.");
					}
					return cell;
				}
			};
		}
		if ("Black".equals(color)) {
			this.figure[i][j] = new Figure("King", "Black", this.board[i][j]) {
/**
* Метод way.
* Определяет возможность передвижения фигуры к заданной ячейке.
* @param dist Текущая ячейка.
* @return Массив ячеек, через которые необходимо пройти фигуре.
* @throws ImposibleMoveException Исключение, если невозможно пройти к ячейке.
*/
				public Cell[] way(Cell dist) throws ImpossibleMoveException {
					Cell[] cell = null;
					int actX = findCoord(this.getPosition()).getX();
					int actY = findCoord(this.getPosition()).getY();
					int distX = findCoord(dist).getX();
					int distY = findCoord(dist).getY();
					int diffX = distX - actX;
					int diffY = distY - actY;
						if (((diffY == 1 || diffY == 0) && (diffX == 1 || diffX == -1)) || (diffY == 1 && diffX == 0)) {
							if ((diffY == -1 || diffY == 0) && (diffX == 1 || diffX == -1)) {
								switch (((diffY == 1 && (diffX == 1 || diffX == -1)) ? 1 : 2)) {
									case 1:
										if (diffY == 1 && diffX == 1) {
											cell = new Cell[1];
											cell[0] = board[distY][distX];
										} else {
											cell = new Cell[1];
											cell[0] = board[distY][distX];
										}
										break;
									case 2:
										if (diffY == 0 && diffX == 1) {
											cell = new Cell[1];
											cell[0] = board[distY][distX];
										} else {
											cell = new Cell[1];
											cell[0] = board[distY][distX];
										}
										break;
									default:
										break;
								}
							} else {
								cell = new Cell[1];
								cell[0] = board[distY][distX];
							}
						} else {
							throw new ImpossibleMoveException("Moving is impossible. Select another cell.");
						}
					return cell;
				}
			};
		}
	}
}
