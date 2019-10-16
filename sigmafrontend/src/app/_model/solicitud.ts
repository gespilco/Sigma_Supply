import { Zona } from './zona';
import { Cliente } from './cliente';
import { TipoSolicitud } from './tipo-solicitud';

export class Solicitud {
    public id_solicitud: number;
    public numero_solicitud: string;
    public cliente: Cliente;
    public tipoSolicitud: TipoSolicitud;
    public descripcion: string;
    public zona: Zona;
    public direccion: string;
    public tipoPrioridad: string;
    public prioridad: string;
    public fechaHoraInicio: Date;
    public fechaHoraFin: Date;
    public fechaRegistro: Date;
    public activo: boolean;
    public usuarioCreacion: string;
    public fechaCreacion: Date;
    public usuarioModificacion: string;
    public fechaModificacion: Date;
    public usuarioEliminacion: string;
    public fechaEliminacion: Date;

}
