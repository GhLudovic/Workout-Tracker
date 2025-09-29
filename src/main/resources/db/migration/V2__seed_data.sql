-- Default muscle groups
INSERT INTO muscle_groups(name, description) VALUES
 ('Chest','Pectorals'),
 ('Back','Lats & traps'),
 ('Legs','Quads & hamstrings'),
 ('Shoulders','Deltoids'),
 ('Arms','Biceps & triceps'),
 ('Core','Abs & lower back');

-- Some exercises (linked to muscle groups)
INSERT INTO exercises(name, description, category, muscle_group_id) VALUES
 ('Bench Press','Barbell bench press','Strength', (SELECT id FROM muscle_groups WHERE name='Chest')),
 ('Incline Dumbbell Press','Incline press for upper chest','Strength', (SELECT id FROM muscle_groups WHERE name='Chest')),
 ('Squat','Back squat','Strength', (SELECT id FROM muscle_groups WHERE name='Legs')),
 ('Deadlift','Conventional deadlift','Strength', (SELECT id FROM muscle_groups WHERE name='Back')),
 ('Overhead Press','Standing military press','Strength', (SELECT id FROM muscle_groups WHERE name='Shoulders')),
 ('Bicep Curl','Dumbbell curls','Strength', (SELECT id FROM muscle_groups WHERE name='Arms')),
 ('Plank','Core stability exercise','Flexibility', (SELECT id FROM muscle_groups WHERE name='Core'));
