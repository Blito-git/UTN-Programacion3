// === 5.1 Interfaces y tipos ===

interface SimpsonCharacter {
  id: number;
  age: number;
  birthdate: string;
  gender: string;
  name: string;
  occupation: string;
  portrait_path: string;
  phrases: string[];
  status: string;
}

interface IResponseApi {
  count: number;
  next: string | null;
  prev: string | null;
  pages: number;
  results: SimpsonCharacter[];
}

// === 5.2 Variables y constantes ===

const API_URL = "https://thesimpsonsapi.com/api/characters";
const IMAGE_BASE_URL = "https://cdn.thesimpsonsapi.com/500";

const loadButton = document.getElementById("load-characters-btn") as HTMLButtonElement;
const loadingSection = document.getElementById("loading-section") as HTMLDivElement;
const errorMessage = document.getElementById("error-message") as HTMLDivElement;
const charactersSection = document.getElementById("characters-section") as HTMLDivElement;

// === 5.3 Funciones requeridas ===

function showLoading(): void {
  loadingSection.style.display = "block";
  errorMessage.style.display = "none";
}

function hideLoading(): void {
  loadingSection.style.display = "none";
}

function showError(message: string): void {
  errorMessage.textContent = message;
  errorMessage.style.display = "block";

  setTimeout(() => {
    errorMessage.style.display = "none";
  }, 5000);
}

function createCharacterCard(character: SimpsonCharacter): HTMLElement {
  const card = document.createElement("div");
  card.classList.add("character-card");

  const img = document.createElement("img");
  img.src = `${IMAGE_BASE_URL}${character.portrait_path}`;
  img.alt = character.name;

  const title = document.createElement("h3");
  title.textContent = character.name;

  const phrase = document.createElement("p");
  phrase.textContent = character.phrases[0] ?? "";

  card.appendChild(img);
  card.appendChild(title);
  card.appendChild(phrase);

  return card;
}

const renderCharacters = (characters: SimpsonCharacter[]): void => {
  charactersSection.innerHTML = "";

  characters.forEach((character) => {
    const card = createCharacterCard(character);
    charactersSection.appendChild(card);
  });
};

const fetchCharacters = async (): Promise<void> => {
  showLoading();

  try {
    const response = await fetch(API_URL);

    if (!response.ok) {
      throw new Error(`Error en la petición: ${response.status}`);
    }

    const data: IResponseApi = await response.json();
    renderCharacters(data.results);
  } catch (error) {
    console.error("Error al obtener los personajes:", error);
    showError("Error al cargar los personajes. Por favor, intente nuevamente.");
  } finally {
    hideLoading();
  }
};

// === 5.4 Event Listeners ===

loadButton.addEventListener("click", () => {
  fetchCharacters();
});
