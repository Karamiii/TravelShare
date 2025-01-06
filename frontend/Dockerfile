# Build
FROM node:18 AS build

# Create a working directory
WORKDIR /app

# Copy packages and install dependencies
COPY package*.json ./
RUN npm install

# Copy the whole project
COPY . .

# Build
RUN npm run build

#
FROM nginx:stable-alpine

# Copy build result to nginx
COPY --from=build /app/dist /usr/share/nginx/html

# Port
EXPOSE 80

# Start the server
CMD ["nginx", "-g", "daemon off;"]
