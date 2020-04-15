#!/bin/bash
# Shell script for initial Setup for database application
# Run the command `bash src/main/resources/Script/dbSetup.sh <teamDataFileName> <playerDataFileName>` from the project root directory for running the script
python3 src/main/resources/Script/teamCreation.py $1
python3 src/main/resources/Script/playerCreation.py $2