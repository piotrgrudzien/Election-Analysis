package wybory;
/**
 * Class stores all indexes and names of candidates / parties
 * @author Piotrek
 *
 */
public class Const {
	/*
	 * Indeks "BrakGlosu" to indeks kolumny "uprawnieni do glosowania", od
	 * ktorej jest odjeta suma pozostalych glosow zeby uzyskac "BrakGlosu"
	 * IdIndexes to kolejno indeks kodu terytorium (gminy) i obwodu
	 */
	public static String[] Names2000 = { "Grabowski", "Ikonowicz", "Kalinowski", "Korwin", "Krzaklewski", "Kwasniewski", "Lepper", "Lopuszanski",
			"Olechowski", "Pawlowski", "Walesa", "Wilecki", "GlosNiewazny", "BrakGlosu" };
	public static int[] CandidateIndexes2000 = { 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 10, 7 };
	public static int[] IdIndexes2000 = { 1, 4 };

	public static String[] Names2005Tura1 = { "Bochniarz", "Borowski", "Bubel", "Ilasz", "Kaczynski L", "Kalinowski", "Korwin", "Lepper",
			"Pyszko", "Slomka", "Tusk", "Tyminski", "GlosNiewazny", "BrakGlosu" };
	public static int[] CandidateIndexes2005Tura1 = { 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 14, 8 };
	public static int[] IdIndexes2005Tura1 = { 1, 4 };

	public static String[] Names2005Tura2 = { "Kaczynski L", "Tusk", "GlosNiewazny", "BrakGlosu" };
	public static int[] CandidateIndexes2005Tura2 = { 13, 15, 9, 5 };
	public static int[] IdIndexes2005Tura2 = { 0, 3 };

	public static String[] Names2010Tura1 = { "Jurek", "Kaczynski J", "Komorowski", "Korwin", "Lepper", "Morawiecki", "Napieralski",
			"Olechowski", "Pawlak", "Zietek", "GlosNiewazny", "BrakGlosu" };
	public static int[] CandidateIndexes2010Tura1 = { 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 10 };
	public static int[] IdIndexes2010Tura1 = { 2, 6 };

	public static String[] Names2010Tura2 = { "Kaczynski J", "Komorowski", "GlosNiewazny", "BrakGlosu" };
	public static int[] CandidateIndexes2010Tura2 = { 14, 15, 16, 10 };
	public static int[] IdIndexes2010Tura2 = { 2, 6 };

	public static String[] Names2015Tura1 = { "Braun", "Duda", "Jarubas", "Komorowski", "Korwin", "Kowalski", "Kukiz", "Ogorek", "Palikot",
			"Tanajno", "Wilk", "GlosNiewazny", "BrakGlosu" };
	public static int[] CandidateIndexes2015Tura1 = { 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 23, 6 };
	public static int[] IdIndexes2015Tura1 = { 2, 3 };

	public static String[] Names2015Tura2 = { "Duda", "Komorowski", "GlosNiewazny", "BrakGlosu" };
	public static int[] CandidateIndexes2015Tura2 = { 23, 24, 21, 4 };
	public static int[] IdIndexes2015Tura2 = { 2, 3 };

	public static String[] Names2001Sejm = { "SLD-UP", "AWSP", "UW", "Samoobrona", "PiS", "PSL", "PO", "ARS", "PWN", "LPR", "MnN", "PUG", "PPS",
			"NMnGSl", "GlosNiewazny", "BrakGlosu" };
	public static int[] CandidateIndexes2001Sejm = { 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 15, 11 };
	public static int[] IdIndexes2001Sejm = { 1, 4 };

	public static String[] Names2005Sejm = { "Ruch Patriotyczny", "Polska Partia Pracy", "Liga Polskich Rodzin", "Partia Demokratyczna",
			"Socjaldemokracja Polska", "Prawo i Sprawiedliwoœæ", "Sojusz Lewicy Demokratycznej", "Platforma Obywatelska",
			"Polska Partia Narodowa", "Polskie Stronnictwo Ludowe", "Centrum", "Platforma Janusza Korwin-Mikke",
			"Ogólnopolska Koalicja Obywatelska O.K.O.", "Polska Konfederacja - Godnoœæ i Praca", "Samoobrona RP", "Inicjatywa RP",
			"Dom Ojczysty", "Narodowe Odrodzenie Polski", "Stronnictwo Pracy", "Spo³eczni Ratownicy", "Mniejszoœæ Niemiecka",
			"Mniejszoœæ Niemiecka Œl¹ska", "GlosNiewazny", "BrakGlosu" };
	public static int[] CandidateIndexes2005Sejm = { 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 9, 6 };
	public static int[] IdIndexes2005Sejm = { 1, 4 };

	public static String[] Names2007Sejm = { "PPP", "LPR", "PiS", "PO", "PSL", "SO", "MnN", "LiD", "PK", "SP", "GlosNiewazny", "BrakGlosu" };
	public static int[] CandidateIndexes2007Sejm = { 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 10 };
	public static int[] IdIndexes2007Sejm = { 1, 6 };

	public static String[] Names2011Sejm = { "Prawo i Sprawiedliwoœæ", "Polska Jest Najwa¿niejsza", "Sojusz Lewicy Demokratycznej",
			"Ruch Palikota", "Polskie Stronnictwo Ludowe", "Polska Partia Pracy - Sierpieñ 80", "Platforma Obywatelska RP",
			"Nasz Dom Polska-Samoobrona Andrzeja Leppera", "Nowa Prawica - Janusza Korwin-Mikke", "Prawica", "Mniejszoœæ Niemiecka", "BrakGlosu",
			"GlosNiewazny" };
	public static int[] CandidateIndexes2011Sejm = { 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 17, 9 };
	public static int[] IdIndexes2011Sejm = { 1, 4 };
}
