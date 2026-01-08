package ar.edu.unlam.pb1.dominio;

//La Pokedex la usamos totalmente Static porque vamos a tener sólamente 1
public class Pokedex {
	
	 public static final int CANTIDAD_TOTAL_POKEMON = 151;
	 private static final Pokemon[] listaPokemon = new Pokemon[CANTIDAD_TOTAL_POKEMON];
	 
	 public static Pokemon obtenerPokemonAleatorio() {
	     int minimo = 1;
	     int maximo = CANTIDAD_TOTAL_POKEMON; // 151
	
	 int numeroAleatorio = (int)(Math.random() * maximo) + minimo;

	 // Le agregamos el -1 ya que el array comienza en la posición 0
	 int posicionDelPokemonEnArray = numeroAleatorio - 1;
	
	     return getListapokemon()[posicionDelPokemonEnArray];
	 }
	 
	 public static void actualizarDatosDelPokemon(String nombrePokemon, int nuevoPoder) {
	     for(int i=0 ; i < getListapokemon().length ; i++){
	         if (getListapokemon()[i] != null && getListapokemon()[i].getNombre().equalsIgnoreCase(nombrePokemon)) {
	             getListapokemon()[i].setPoder(nuevoPoder);
	             return;
	         }
	     }
	 }
	
	 private static void cargarPokemon(int codigo, String nombre, String tipo, int poder) {
	     for(int i=0 ; i < getListapokemon().length ; i++){
	         if (getListapokemon()[i] == null) {
	             getListapokemon()[i] = new Pokemon(codigo, nombre, tipo, poder);
	             return;
	         }
	     }
	 }
	
	 public String toString(){
	     return "Cantidad total de Pokemons: " + CANTIDAD_TOTAL_POKEMON;
	 }
	 
	 public static void inicializarListaPokemon(){
	     // Generación 1 (Kanto)
	 cargarPokemon(1, "Bulbasaur", "PLANTA", 7); // #001
	 cargarPokemon(2, "Ivysaur", "PLANTA", 8);   // #002
	 cargarPokemon(3, "Venusaur", "PLANTA", 9); // #003
	 cargarPokemon(4, "Charmander", "FUEGO", 7); // #004
	 cargarPokemon(5, "Charmeleon", "FUEGO", 8); // #005
	 cargarPokemon(6, "Charizard", "FUEGO", 9); // #006
	 cargarPokemon(7, "Squirtle", "AGUA", 7); // #007
	 cargarPokemon(8, "Wartortle", "AGUA", 8); // #008
	 cargarPokemon(9, "Blastoise", "AGUA", 9); // #009
	 cargarPokemon(10, "Caterpie", "BICHO", 2); // #010
	 cargarPokemon(11, "Metapod", "BICHO", 2); // #011
	 cargarPokemon(12, "Butterfree", "BICHO", 3); // #012
	 cargarPokemon(13, "Weedle", "BICHO", 2); // #013
	 cargarPokemon(14, "Kakuna", "BICHO", 2); // #014
	 cargarPokemon(15, "Beedrill", "BICHO", 4); // #015
	 cargarPokemon(16, "Pidgey", "NORMAL", 2); // #016
	 cargarPokemon(17, "Pidgeotto", "NORMAL", 3); // #017
	 cargarPokemon(18, "Pidgeot", "NORMAL", 5); // #018
	 cargarPokemon(19, "Rattata", "NORMAL", 2); // #019
	 cargarPokemon(20, "Raticate", "NORMAL", 3); // #020
	 cargarPokemon(21, "Spearow", "NORMAL", 2); // #021
	 cargarPokemon(22, "Fearow", "NORMAL", 4); // #022
	 cargarPokemon(23, "Ekans", "VENENO", 3); // #023
	 cargarPokemon(24, "Arbok", "VENENO", 4); // #024
	 cargarPokemon(25, "Pikachu", "ELECTRICO", 7); // #025
	 cargarPokemon(26, "Raichu", "ELECTRICO", 6); // #026
	 cargarPokemon(27, "Sandshrew", "TIERRA", 3); // #027
	 cargarPokemon(28, "Sandslash", "TIERRA", 4); // #028
	 cargarPokemon(29, "NidoranH", "VENENO", 3); // #029
	 cargarPokemon(30, "Nidorina", "VENENO", 4); // #030
	 cargarPokemon(31, "Nidoqueen", "VENENO", 6); // #031
	 cargarPokemon(32, "NidoranM", "VENENO", 3); // #032
	 cargarPokemon(33, "Nidorino", "VENENO", 4); // #033
	 cargarPokemon(34, "Nidoking", "VENENO", 6); // #034
	 cargarPokemon(35, "Clefairy", "NORMAL", 3); // #035
	 cargarPokemon(36, "Clefable", "NORMAL", 4); // #036
	 cargarPokemon(37, "Vulpix", "FUEGO", 4); // #037
	 cargarPokemon(38, "Ninetales", "FUEGO", 5); // #038
	 cargarPokemon(39, "Jigglypuff", "NORMAL", 3); // #039
	 cargarPokemon(40, "Wigglytuff", "NORMAL", 4); // #040
	 cargarPokemon(41, "Zubat", "VENENO", 2); // #041
	 cargarPokemon(42, "Golbat", "VENENO", 4); // #042
	 cargarPokemon(43, "Oddish", "PLANTA", 3); // #043
	 cargarPokemon(44, "Gloom", "PLANTA", 4); // #044
	 cargarPokemon(45, "Vileplume", "PLANTA", 5); // #045
	 cargarPokemon(46, "Paras", "BICHO", 2); // #046
	 cargarPokemon(47, "Parasect", "BICHO", 3); // #047
	 cargarPokemon(48, "Venonat", "BICHO", 2); // #048
	 cargarPokemon(49, "Venomoth", "BICHO", 4); // #049
	 cargarPokemon(50, "Diglett", "TIERRA", 2); // #050
	 cargarPokemon(51, "Dugtrio", "TIERRA", 4); // #051
	 cargarPokemon(52, "Meowth", "NORMAL", 3); // #052
	 cargarPokemon(53, "Persian", "NORMAL", 4); // #053
	 cargarPokemon(54, "Psyduck", "AGUA", 3); // #054
	 cargarPokemon(55, "Golduck", "AGUA", 4); // #055
	 cargarPokemon(56, "Mankey", "LUCHA", 3); // #056
	 cargarPokemon(57, "Primeape", "LUCHA", 4); // #057
	 cargarPokemon(58, "Growlithe", "FUEGO", 5); // #058
	 cargarPokemon(59, "Arcanine", "FUEGO", 7); // #059
	 cargarPokemon(60, "Poliwag", "AGUA", 3); // #060
	 cargarPokemon(61, "Poliwhirl", "AGUA", 4); // #061
	 cargarPokemon(62, "Poliwrath", "AGUA", 5); // #062
	 cargarPokemon(63, "Abra", "PSIQUICO", 5); // #063
	 cargarPokemon(64, "Kadabra", "PSIQUICO", 6); // #064
	 cargarPokemon(65, "Alakazam", "PSIQUICO", 7); // #065
	 cargarPokemon(66, "Machop", "LUCHA", 4); // #066
	 cargarPokemon(67, "Machoke", "LUCHA", 5); // #067
	 cargarPokemon(68, "Machamp", "LUCHA", 7); // #068
	 cargarPokemon(69, "Bellsprout", "PLANTA", 3); // #069
	 cargarPokemon(70, "Weepinbell", "PLANTA", 4); // #070
	 cargarPokemon(71, "Victreebel", "PLANTA", 5); // #071
	 cargarPokemon(72, "Tentacool", "AGUA", 3); // #072
	 cargarPokemon(73, "Tentacruel", "AGUA", 5); // #073
	 cargarPokemon(74, "Geodude", "ROCA", 3); // #074
	 cargarPokemon(75, "Graveler", "ROCA", 4); // #075
	 cargarPokemon(76, "Golem", "ROCA", 5); // #076
	 cargarPokemon(77, "Ponyta", "FUEGO", 4); // #077
	 cargarPokemon(78, "Rapidash", "FUEGO", 5); // #078
	 cargarPokemon(79, "Slowpoke", "AGUA", 3); // #079
	 cargarPokemon(80, "Slowbro", "AGUA", 4); // #080
	 cargarPokemon(81, "Magnemite", "ELECTRICO", 4); // #081
	 cargarPokemon(82, "Magneton", "ELECTRICO", 5); // #082
	 cargarPokemon(83, "Farfetch'd", "NORMAL", 4); // #083
	 cargarPokemon(84, "Doduo", "NORMAL", 3); // #084
	 cargarPokemon(85, "Dodrio", "NORMAL", 4); // #085
	 cargarPokemon(86, "Seel", "AGUA", 3); // #086
	 cargarPokemon(87, "Dewgong", "AGUA", 4); // #087
	 cargarPokemon(88, "Grimer", "VENENO", 3); // #088
	 cargarPokemon(89, "Muk", "VENENO", 4); // #089
	 cargarPokemon(90, "Shellder", "AGUA", 3); // #090
	 cargarPokemon(91, "Cloyster", "AGUA", 5); // #091
	 cargarPokemon(92, "Gastly", "FANTASMA", 4); // #092
	 cargarPokemon(93, "Haunter", "FANTASMA", 5); // #093
	 cargarPokemon(94, "Gengar", "FANTASMA", 7); // #094
	 cargarPokemon(95, "Onix", "ROCA", 5); // #095
	 cargarPokemon(96, "Drowzee", "PSIQUICO", 3); // #096
	 cargarPokemon(97, "Hypno", "PSIQUICO", 4); // #097
	 cargarPokemon(98, "Krabby", "AGUA", 3); // #098
	 cargarPokemon(99, "Kingler", "AGUA", 4); // #099
	 cargarPokemon(100, "Voltorb", "ELECTRICO", 3); // #100
	 cargarPokemon(101, "Electrode", "ELECTRICO", 4); // #101
	 cargarPokemon(102, "Exeggcute", "PLANTA", 4); // #102
	 cargarPokemon(103, "Exeggutor", "PLANTA", 6); // #103
	 cargarPokemon(104, "Cubone", "TIERRA", 4); // #104
	 cargarPokemon(105, "Marowak", "TIERRA", 5); // #105
	 cargarPokemon(106, "Hitmonlee", "LUCHA", 6); // #106
	 cargarPokemon(107, "Hitmonchan", "LUCHA", 6); // #107
	 cargarPokemon(108, "Lickitung", "NORMAL", 4); // #108
	 cargarPokemon(109, "Koffing", "VENENO", 3); // #109
	 cargarPokemon(110, "Weezing", "VENENO", 4); // #110
	 cargarPokemon(111, "Rhyhorn", "TIERRA", 5); // #111
	 cargarPokemon(112, "Rhydon", "TIERRA", 7); // #112
	 cargarPokemon(113, "Chansey", "NORMAL", 5); // #113
	 cargarPokemon(114, "Tangela", "PLANTA", 4); // #114
	 cargarPokemon(115, "Kangaskhan", "NORMAL", 6); // #115
	 cargarPokemon(116, "Horsea", "AGUA", 3); // #116
	 cargarPokemon(117, "Seadra", "AGUA", 4); // #117
	 cargarPokemon(118, "Goldeen", "AGUA", 2); // #118
	 cargarPokemon(119, "Seaking", "AGUA", 3); // #119
	 cargarPokemon(120, "Staryu", "AGUA", 4); // #120
	 cargarPokemon(121, "Starmie", "AGUA", 7); // #121
	 cargarPokemon(122, "Mr. Mime", "PSIQUICO", 5); // #122
	 cargarPokemon(123, "Scyther", "BICHO", 7); // #123
	 cargarPokemon(124, "Jynx", "HIELO", 5); // #124
	 cargarPokemon(125, "Electabuzz", "ELECTRICO", 6); // #125
	 cargarPokemon(126, "Magmar", "FUEGO", 6); // #126
	 cargarPokemon(127, "Pinsir", "BICHO", 6); // #127
	 cargarPokemon(128, "Tauros", "NORMAL", 6); // #128
	 cargarPokemon(129, "Magikarp", "AGUA", 1); // #129
	 cargarPokemon(130, "Gyarados", "AGUA", 7); // #130
	 cargarPokemon(131, "Lapras", "AGUA", 8); // #131
	 cargarPokemon(132, "Ditto", "NORMAL", 5); // #132
	 cargarPokemon(133, "Eevee", "NORMAL", 7); // #133
	 cargarPokemon(134, "Vaporeon", "AGUA", 7); // #134
	 cargarPokemon(135, "Jolteon", "ELECTRICO", 7); // #135
	 cargarPokemon(136, "Flareon", "FUEGO", 7); // #136
	 cargarPokemon(137, "Porygon", "NORMAL", 6); // #137
	 cargarPokemon(138, "Omanyte", "ROCA", 6); // #138
	 cargarPokemon(139, "Omastar", "ROCA", 7); // #139
	 cargarPokemon(140, "Kabuto", "ROCA", 6); // #140
	 cargarPokemon(141, "Kabutops", "ROCA", 7); // #141
	 cargarPokemon(142, "Aerodactyl", "ROCA", 8); // #142
	 cargarPokemon(143, "Snorlax", "NORMAL", 7); // #143
	 cargarPokemon(144, "Articuno", "HIELO", 9); // #144
	 cargarPokemon(145, "Zapdos", "ELECTRICO", 9); // #145
	 cargarPokemon(146, "Moltres", "FUEGO", 9); // #146
	 cargarPokemon(147, "Dratini", "DRAGON", 7); // #147
	 cargarPokemon(148, "Dragonair", "DRAGON", 8); // #148
	 cargarPokemon(149, "Dragonite", "DRAGON", 9); // #149
	 cargarPokemon(150, "Mewtwo", "PSIQUICO", 10); // #150
	 cargarPokemon(151, "Mew", "PSIQUICO", 10); // #151
	 }
	
	public static Pokemon[] getListapokemon() {
		return listaPokemon;
	}
}
