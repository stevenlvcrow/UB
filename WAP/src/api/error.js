import { Message } from 'element-ui';

let error = function (error) {
    Message.error({
        message: error
    });
};

export default error;