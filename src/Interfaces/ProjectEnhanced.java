package Interfaces;

import Participants.ParticipantImp;
import ma02_resources.project.Project;

public interface ProjectEnhanced extends Project{

    void removeTag(String tag);

    ParticipantImp[] getParticipants();
}
