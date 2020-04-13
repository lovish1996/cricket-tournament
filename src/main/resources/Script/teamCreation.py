# Run the command "python3 src/main/resources/Script/teamCreation.py <DataFileName>" from the project root directory for running the script
import os
import sys
import pandas as pd
import requests
import json


host = "localhost"
port= "8080"
apiEndPoint = "/teams/createTeam"

def isNaN(num):
    return num != num

def generate(fileName):

    pathForData = "src/main/resources/Data/"+fileName
    teamData = pd.read_excel(pathForData)

    # API to hit the post request
    apiToHit = host + ":" + port + apiEndPoint

    for ind in range(teamData.shape[0]):
        teamName = teamData.iloc[ind,0]
        testRanking = int(teamData.iloc[ind,1])
        odiRanking = int(teamData.iloc[ind,2])
        t20Ranking = int(teamData.iloc[ind,3])

        json_str={}

        json_str = {
                        "teamName" : teamName,
                        "rankingRequestResponse" : {
                            "testRanking" : testRanking,
                            "odiRanking" : odiRanking,
                            "t20Ranking" : t20Ranking
                        }
                    }

        command = "curl -X POST -H 'Content-type: application/json' --data '" + json.dumps(json_str) +  "' " + apiToHit
        os.system(command)

if __name__=="__main__":
    fileName = sys.argv[1]
    generate(fileName)