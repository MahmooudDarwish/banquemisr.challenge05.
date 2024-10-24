# MOOVIZ App

A modern Android application that displays a list of movies currently playing, popular movies, and
upcoming releases using The Movie Database (TMDb) API. The app is built with Jetpack Compose,
following the MVVM (Model-View-ViewModel) architecture pattern and utilizing Coroutines for
asynchronous operations.

## Table of Contents

- [Features](#features)
- [Screenshots](#screenshots)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Architecture](#architecture)
- [Unit Testing](#unit-testing)
- [Error Handling](#error-handling)

## Features

- **Three Tabs**: View now playing, popular, and upcoming movies.
- **Movie List**: Horizontal list view of movies with title, release date, and poster image.
- **Movie Detail Screen**: Detailed information about each movie, including overview, genres, and
  runtime.
- **Navigation**: Seamless navigation between list and detail screens.
- **Caching**: Efficient data caching to minimize network requests.
- **Error Handling**: User-friendly error messages for failed data retrieval.

## Screenshots

| Now Playing Movies                               | Popular Movies                                   | Upcoming Movies                        | Movie Detail Screen                              |
|--------------------------------------------------|--------------------------------------------------|----------------------------------------|--------------------------------------------------|
| ![Now_Playing.png](screen_shots/now_playing.jpg) | ![Popular](screen_shots/popular.jpg)             | ![Upcoming](screen_shots/upcoming.jpg) | ![Detail Screen](screen_shots/movie_details.jpg) |
| No Internet                                      | Error Handle                                     |
| ![No_Internet](screen_shots/no_internet.jpg)     | ![Error Handle](screen_shots/error_handling.jpg) |

## Technologies Used

- **Kotlin**: Programming language used for the application.
- **Jetpack Compose**: UI toolkit for building native Android interfaces.
- **Coroutines**: For handling asynchronous operations.
- **MVVM**: Architecture pattern for managing UI-related logic.
- **Retrofit**: Networking library for API calls.
- **Navigation Component**: For handling navigation between screens.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/MahmooudDarwish/banquemisr.challenge05..git
2. Open the project in Android Studio.
3. Sync the Gradle files and run the app on an emulator or physical device.

## Usage

- Navigate between tabs to view different categories of movies.
- Click on a movie to view its details.
- Use the back button to return to the movie list.

## Architecture

This application is structured using the MVVM (Model-View-ViewModel) architecture. Each component is
separated into distinct layers:

- **Model**: Represents the data and business logic.
- **View**: Composed UI elements using Jetpack Compose.
- **ViewModel**: Manages the UI-related data in a lifecycle-conscious way, providing data to the
  View and handling user interactions.

## Unit Testing

Comprehensive unit tests have been written to cover critical components, including:

- Domain logic.
- Data retrieval from the TMDb API.
- UI interactions using Jetpack Compose testing utilities.

## Error Handling

The app includes robust error handling mechanisms that provide users with informative error messages
in case of:

- Network errors.
- API failures.
- Unexpected exceptions.