class Node:
    def __init__(self, plate_name= None, inspection_date_time=None, defects_number=None):
        self.inspection_date_time = inspection_date_time
        self.defects_number = defects_number
        self.plate_name = plate_name