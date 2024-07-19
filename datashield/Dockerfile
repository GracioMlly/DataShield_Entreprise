# Utilise une image de base Node.js
FROM node:20

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le package.json et le package-lock.json
COPY package*.json ./

# Installer les dépendances, y compris Vite
RUN npm install vite@latest esbuild@latest --save-dev

# Installer les autres dépendances
RUN npm install

# Copier le reste de l'application dans le répertoire de travail
COPY . .

# Commande pour démarrer l'application en mode développement
CMD ["npm", "run", "dev"]
