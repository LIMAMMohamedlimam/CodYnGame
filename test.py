import os

def create_files(directory):
    # Ensure the directory exists, if not, create it
    if not os.path.exists(directory):
        os.makedirs(directory)
    
    # Define the file names and their extensions
    filenames = [str(i) for i in range(2, 11)]
    extensions = ['.py', '.c', '.js', '.php', '.java']
    
    # Loop through filenames and extensions to create files
    for filename in filenames:
        for extension in extensions:
            # Combine the directory, filename, and extension to form the full path
            full_path = os.path.join(directory, filename + extension)
            # Create and close the file
            with open(full_path, 'w') as file:
                file.write("")  # You can customize to write specific content to each file

# Usage example
directory_path = "/home/mohamed/Java_IHM/CodYnGame/DefaultCodeInputOutput"  # Change this to the desired path
create_files(directory_path)
