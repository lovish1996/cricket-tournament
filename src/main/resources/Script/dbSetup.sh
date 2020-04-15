#!/bin/bash
# Shell script for initial Setup for database application
# Run the command `bash src/main/resources/Script/dbSetup.sh` from the project root directory for running the script

config=src/main/resources/Script/setup.config
source $config

teamDataFileName=$team_data_filename
playerDataFileName=$player_data_filename

python3 src/main/resources/Script/teamCreation.py $teamDataFileName
python3 src/main/resources/Script/playerCreation.py $playerDataFileName