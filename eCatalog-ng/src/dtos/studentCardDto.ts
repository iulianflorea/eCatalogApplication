import { SchoolClassDto } from "./schoolClassDto";

export class StudentCardDto {
    id?: number;
    firstName?: string;
    lastName?: string;
    schoolClassDto?: SchoolClassDto;
    deleteStudent?: string;
    schoolClassId?: number;
}
