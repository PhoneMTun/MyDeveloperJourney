import React, { useState } from 'react';
import axios from 'axios';

import { TextField, Button,  Container, Box } from '@mui/material';

export default function Form({submithandler,errors, initialname, setName }) {

    return (
        <Container maxWidth="sm">
        

            <Box component="form" onSubmit={submithandler} noValidate sx={{ mt: 1 }}>
            <TextField
    required
    fullWidth
    id="name"
    label="Name"
    name="name"
    margin="normal"
    value={initialname}
    onChange={(e) => setName(e.target.value)}
    error={Boolean(errors.name)}
    helperText={errors.name ? errors.name.message : ''}
    sx={{
        '& label.Mui-focused': {
            color: 'white',
        },
        '& .MuiInput-underline:after': {
            borderBottomColor: 'white',
        },
        '& .MuiOutlinedInput-root': {
            '& fieldset': {
                borderColor: 'white',
            },
            '&:hover fieldset': {
                borderColor: 'white',
            },
            '&.Mui-focused fieldset': {
                borderColor: 'white',
            },
        },
        input: {
            color: 'white',
        }
    }}
    InputLabelProps={{
        style: { color: 'white' },
    }}
/>
                <Button 
                    type="submit" 
                    fullWidth 
                    variant="contained" 
                    sx={{ mt: 3, mb: 2 }}
                >
                    Submit
                </Button>
            </Box>
        </Container>
    );
}
