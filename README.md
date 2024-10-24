# Building a Ransomware Simulator

## Table of Contents
- [Project Overview](#project-overview)
- [Objectives](#objectives)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Testing Results](#testing-results)
- [Screenshots](#screenshots)
- [License](#license)
- [Acknowledgments](#acknowledgments)

## Project Overview

This project aims to create a ransomware simulator that mimics the behavior of real ransomware in a controlled environment. The simulator focuses on understanding ransomware attacks by simulating the encryption of files and displaying a ransom note to the user. 

### Objectives
- **Understand Ransomware Behavior**: Gain insights into how ransomware operates through simulation.
- **Demonstrate Risks**: Illustrate the potential risks associated with ransomware attacks and emphasize the importance of cybersecurity.
- **Educate Users**: Raise awareness about ransomware and promote preventative strategies.

## Features
- **File System Interaction**: Simulates targeting specific files for encryption, mimicking real-world ransomware behavior.
- **Encryption Module**: Implements AES (Advanced Encryption Standard) to securely encrypt files.
- **Key Management**: Efficiently manages encryption keys required for the decryption process.
- **User Interface (GUI)**: A simple and effective GUI displays a ransom note with recovery instructions.
- **Testing and Results**: Comprehensive testing to verify the functionality of encryption/decryption processes and track indicators of compromise (IoCs).

## Technologies Used
- **Programming Language**: Java
- **Development Environment**: IntelliJ IDEA
- **Virtualization**: Oracle VM VirtualBox
- **GUI Framework**: Java Swing
- **Encryption Algorithm**: AES (Advanced Encryption Standard)

## Installation

To set up the ransomware simulator on your machine, follow these steps:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/ganesh2394/Ransomware-Simulator.git

## Usage

1. **Set Up a Virtual Machine**: 
   Use Oracle VM VirtualBox to create a virtual environment where the simulator can operate safely.

2. **Run the Simulator**: 
   Execute the application within your development environment (e.g., IntelliJ IDEA) to start the simulator.

3. **Follow GUI Instructions**: 
   Interact with the GUI to select files for encryption. Observe how the ransom note is displayed after the selected files have been encrypted.

## Testing Results

The simulator has undergone extensive testing to ensure the following:
- **Successful file encryption and decryption**: All test files were correctly encrypted and could be decrypted using the same key.
- **Proper functionality of the GUI**: The GUI displayed the ransom note as intended and allowed users to interact with the application.
- **Tracking of indicators of compromise (IoCs)**: The application effectively tracked and displayed IoCs related to the simulated ransomware activity, demonstrating the potential impact of such attacks.

## Screenshots

Here are some screenshots demonstrating the functionality of the ransomware simulator:

### File/Directory Choose
![Main GUI](Screenshots/FileChoosenDirectory.png)

### Operation : Encryption or Decryption
![Ransom Note Display](Screenshots/OptionsforOperations.png)

### Ransomeware Note Example 
![Encryption Process](Screenshots/RansomNote.png)

*Ensure that the paths in the README correspond to where the screenshots are stored in your GitHub repository.*

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [Ganesh](https://github.com/yourusername) - Project Creator
